/**
 * Copyright (c) Daniel Doubrovkine, 2010
 * dblock[at]dblock[dot]org
 * All Rights Reserved
 * Eclipse Public License (EPLv1)
 * http://oshi.codeplex.com/license
 */
package oshi.hardware;

import oshi.hardware.storage.Storage;
import oshi.util.NoSuchDeviceException;

/**
 * A hardware abstraction layer.
 * @author dblock[at]dblock[dot]org
 */
public interface HardwareAbstractionLayer {

	/**
	 * Get CPUs.
	 * @return
	 *  An array of Processor objects.
	 */
	Processor[] getProcessors();
	
	/**
	 * Get Memory information.
	 * @return
	 *  A memory object.
	 */
	Memory getMemory();

	/**
	 * Get storage devices.
	 * @return array of storage devices.
	 * @throws NoSuchDeviceException if no storage device is present.
	 */
	Storage[] getStorage() throws NoSuchDeviceException;

}
