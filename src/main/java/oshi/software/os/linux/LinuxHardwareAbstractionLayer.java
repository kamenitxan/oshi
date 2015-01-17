package oshi.software.os.linux;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oshi.hardware.Gpu;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Memory;
import oshi.hardware.Processor;
import oshi.software.os.linux.proc.CentralProcessor;
import oshi.software.os.linux.proc.GlobalMemory;
import oshi.software.os.linux.proc.GraphicCard;
import oshi.util.ExecutingCommand;

/**
 * @author alessandro[at]perucchi[dot]org
 */

public class LinuxHardwareAbstractionLayer implements HardwareAbstractionLayer {

	private static final String SEPARATOR = "\\s+:\\s";
	private Processor[] _processors = null;
	private Memory _memory = null;
	private Gpu[] _gpu = null;

	public Memory getMemory() {
		if (_memory == null) {
			_memory = new GlobalMemory();
		}
		return _memory;
	}

	public Processor[] getProcessors() {

		if (_processors == null) {
			List<Processor> processors = new ArrayList<Processor>();
			Scanner in = null;
			try {
				in = new Scanner(new FileReader("/proc/cpuinfo"));
			} catch (FileNotFoundException e) {
				System.err.println("Problem with: /proc/cpuinfo");
				System.err.println(e.getMessage());
				return null;
			}
			in.useDelimiter("\n");
			CentralProcessor cpu = null;
			while (in.hasNext()) {
				String toBeAnalyzed = in.next();
				if (toBeAnalyzed.equals("")) {
					if (cpu != null) {
						processors.add(cpu);
					}
					cpu = null;
					continue;
				}
				if (cpu == null) {
					cpu = new CentralProcessor();
				}
				if (toBeAnalyzed.startsWith("model name\t")) {
					cpu.setName(toBeAnalyzed.split(SEPARATOR)[1]); // model
																	// name
					continue;
				}
				if (toBeAnalyzed.startsWith("flags\t")) {
					String[] flags=toBeAnalyzed.split(SEPARATOR)[1].split(" ");
					boolean found=false;
					for (String flag: flags) {
						if (flag.equalsIgnoreCase("LM")) {
							found=true;
							break;
						}
					}
					cpu.setCpu64(found);
					continue;
				}
				if (toBeAnalyzed.startsWith("cpu family\t")) {
					cpu.setFamily(toBeAnalyzed.split(SEPARATOR)[1]); // model
																	// name
					continue;
				}
				if (toBeAnalyzed.startsWith("model\t")) {
					cpu.setModel(toBeAnalyzed.split(SEPARATOR)[1]); // model
																	// name
					continue;
				}
				if (toBeAnalyzed.startsWith("stepping\t")) {
					cpu.setStepping(toBeAnalyzed.split(SEPARATOR)[1]); // model
																	// name
					continue;
				}
				if (toBeAnalyzed.startsWith("vendor_id")) {
					cpu.setVendor(toBeAnalyzed.split(SEPARATOR)[1]); // vendor_id
					continue;
				}
			}
			in.close();
			if (cpu != null) {
				processors.add(cpu);
			}
			_processors = processors.toArray(new Processor[0]);
		}

		return _processors;
	}

	public Gpu[] getGpus() {
		if (_gpu == null) {
			List<Gpu> gpus = new ArrayList<Gpu>();
			ArrayList<String> sys_profile = ExecutingCommand.runNative("lshw -class display");
			for (int i = 0; i < sys_profile.size(); i++) {
				if (sys_profile.get(i).contains("*-display")) {
					String model = sys_profile.get(i+2).replace("product: ", "").trim();
					try {
						model = model.substring(model.indexOf("["), model.lastIndexOf("]"));
					} catch (StringIndexOutOfBoundsException ex) {
						model = sys_profile.get(i+2).replace("product: ", "").trim();
					}
					String vendor = sys_profile.get(i+3).replace("vendor: ", "").trim();
					gpus.add(new GraphicCard(model, vendor, 42));
				}
			}
			_gpu = gpus.toArray(new Gpu[gpus.size()]);
		}
		return _gpu;
	}

}
