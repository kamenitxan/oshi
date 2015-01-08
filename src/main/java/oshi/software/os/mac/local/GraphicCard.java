package oshi.software.os.mac.local;

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

	/**
	 *
	 * @param model eg. "Chipset Model: NVIDIA GeForce GTX 650 Ti"
	 */
	public GraphicCard(String model) {
		ArrayList<String> sys_profile = ExecutingCommand.runNative("system_profiler SPDisplaysDataType");
		for (int i = 0; i < sys_profile.size(); i++) {
			if (sys_profile.get(i).contains(model)) {
				_name = model.replace("Chipset Model: ", "").trim();
				_vendor = sys_profile.get(i+5).replace("Vendor: ", "").replaceAll("\\([^)]+\\)", "").trim();
				_totalMemory = Long.valueOf(sys_profile.get(i+4).replaceAll("\\D+","")) * 1048576;
				break;
			}
		}
	}

	public String getVendor() {
		return _vendor;
	}

	public void setVendor(String vendor) {
		_vendor = vendor;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getTotalMemory() {
		return _totalMemory;
	}
}
