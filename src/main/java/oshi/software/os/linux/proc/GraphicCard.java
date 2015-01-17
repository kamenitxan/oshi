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

	public GraphicCard(String model, String vendor, long totalMemory) {
		_name = model;
		_vendor = vendor.replace(" Technologies Inc", "").replace(" Technologies Inc", "");
		_totalMemory = totalMemory;
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
