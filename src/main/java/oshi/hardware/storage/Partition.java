package oshi.hardware.storage;

/**
 * Disk partitioning is the act of dividing a hard disk drive (HDD) into multiple logical storage units referred to as
 * partitions, to treat one physical disk drive as if it were multiple disks.
 * @author Kamenitxan (kamenitxan[at]me[dot]com)
 */
public interface Partition {
	/**
	 * @return name of partition.
	 */
	String getName();

	/**
	 * @return system identifier of storage device e.g. disk2s1
	 */
	String getIdentifier();

	/**
	 * Total partition size.
	 * @return Total number of bytes.
	 */
	long getTotal();

	/**
	 * @return bytes used on partition.
	 */
	long getUsed();

	/**
	 * @return bytes free on partition.
	 */
	long getFree();

	/**
	 * @return % used on partition.
	 */
	int getUsedPercentage();

	/**
	 * @return used file system.
	 */
	String getFileSystem();
}
