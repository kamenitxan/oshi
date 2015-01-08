/**
 * Copyright (c) Daniel Doubrovkine, 2010
 * dblock[at]dblock[dot]org
 * All Rights Reserved
 * Eclipse Public License (EPLv1)
 * http://oshi.codeplex.com/license
 */
package oshi.hardware;

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
	 * Get GPUs.
	 * @return An array of GPU objects.
	 */
	Gpu[] getGpus();

	/**
	 * Get Memory information.
	 * @return
	 *  A memory object.
	 */
	Memory getMemory();

}
