package oshi.hardware.storage;

/**
 * A data storage device is a device for recording (storing) information (data). It could be HDD, SDD, USB flash disk
 * or other similar devices.
 * @author Kamenitxan (kamenitxan[at]me[dot]com)
 */
public interface Storage {
	/**
	 * @return name of storage device.
	 */
	String getName();

	/**
	 * @return system identifier of storage device e.g. disk2s1
	 */
	String getIdentifier();

	/**
	 * Total size of disk.
	 * @return Total number of bytes.
	 */
	long getTotal();

	/**
	 * @return bytes used on all partitions.
	 */
	long getUsed();

	/**
	 * @return bytes free on all partitions.
	 */
	long getFree();

	/**
	 * @return % used on device.
	 */
	int getUsedPercentage();

	/**
	 * @return array of partitions.
	 */
	Partition[] getPartitions();
}
