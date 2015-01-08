package oshi.hardware;

/**
 * A graphics card (also called a video adapter, display card, video card, graphics board, display adapter,
 * graphics adapter or frame buffer[1] and sometimes preceded by the word discrete or dedicated to emphasize
 * the distinction between this implementation and integrated graphics) is an expansion card which generates
 * a feed of output images to a display (such as a computer monitor).
 * @author kamenitxan[at]me[dot]com
 */
public interface Gpu {
	/**
	 * GPU vendor.
	 * @return String.
	 */
	String getVendor();

	/**
	 * Set GPU vendor.
	 * @param vendor Vendor.
	 */
	void setVendor(String vendor);

	/**
	 * Name, eg. NVIDIA GeForce GTX 650 Ti
	 * @return GPU name.
	 */
	String getName();

	/**
	 * Set GPU name.
	 * @param name Name.
	 */
	void setName(String name);

	/**
	 * Total graphic memory.
	 * @return
	 *  Total number of bytes.
	 */
	long getTotalMemory();
}
