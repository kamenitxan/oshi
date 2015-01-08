package oshi.software.os.linux.proc;

import oshi.hardware.Gpu;
import oshi.util.ExecutingCommand;

import java.util.ArrayList;

/**
 * A GPU
 * @author kamenitxan[at]me[dot]com
 */
public class GraphicCard implements Gpu{
	private String _vendor;
	private String _name;
	private long _totalMemory;

	public GraphicCard(String model) {
		ArrayList<String> sys_profile = ExecutingCommand.runNative("lspci -vnn");
		for (int i = 0; i < sys_profile.size(); i++) {
			if (sys_profile.get(i).contains(model)) {
				_name = model.replace("Chipset Model: ", "").trim();
				_vendor = sys_profile.get(i+2).replace("Vendor: ", "").replaceAll("\\([^)]+\\)", "").trim();
				_totalMemory = Long.valueOf(sys_profile.get(i+2)) * 1048576;
				break;
			}
		}
	}


	public String getVendor() {
		return _vendor;
	}

	public void setVendor(String vendor) {

	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {

	}

	public long getTotalMemory() {
		return _totalMemory;
	}
}
