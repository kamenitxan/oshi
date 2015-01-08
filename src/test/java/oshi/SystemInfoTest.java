/**
 * Copyright (c) Daniel Doubrovkine, 2010 dblock[at]dblock[dot]org All Rights
 * Reserved Eclipse Public License (EPLv1) http://oshi.codeplex.com/license
 */
package oshi;

import org.junit.Test;
import static org.junit.Assert.*;

import oshi.hardware.Gpu;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Memory;
import oshi.hardware.Processor;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystemVersion;
import oshi.util.FormatUtil;

/**
 * @author dblock[at]dblock[dot]org
 */
public class SystemInfoTest {

    @Test
    public void testGetVersion() {
        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        assertNotNull(os);
        OperatingSystemVersion version = os.getVersion();
        assertNotNull(version);
        assertTrue(os.toString().length() > 0);
    }

    @Test
    public void testGetProcessors() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        assertTrue(hal.getProcessors().length > 0);
    }

    @Test
    public void testGetMemory() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        Memory memory = hal.getMemory();
        assertNotNull(memory);
        assertTrue(memory.getTotal() > 0);
        assertTrue(memory.getAvailable() >= 0);
        assertTrue(memory.getAvailable() <= memory.getTotal());
    }

    @Test
    public void testCpuLoad() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        assertTrue(hal.getProcessors()[0].getLoad() >= 0 && hal.getProcessors()[0].getLoad() <= 100);
    }

    @Test
    public void testGpus() {
        SystemInfo si = new SystemInfo();
        Gpu[] gpus = si.getHardware().getGpus();
        assertTrue(gpus.length > 0);
    }

    @Test
    public void testGpuMemory() {
        SystemInfo si = new SystemInfo();
        Gpu[] gpus = si.getHardware().getGpus();
        for (Gpu gpu : gpus) {
            assertTrue(gpu.getTotalMemory() > 0);
        }
    }

    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        // software
        // software: operating system
        OperatingSystem os = si.getOperatingSystem();
        System.out.println(os);
        // hardware
        HardwareAbstractionLayer hal = si.getHardware();
        // hardware: processors
        System.out.println(hal.getProcessors().length + " CPU(s):");
        for (Processor cpu : hal.getProcessors()) {
            System.out.println(" " + cpu);
        }
        // hardware: memory
        System.out.println("Memory: "
                + FormatUtil.formatBytes(hal.getMemory().getAvailable()) + "/"
                + FormatUtil.formatBytes(hal.getMemory().getTotal()));
        System.out.println("CPU load: " + hal.getProcessors()[0].getLoad() + "%");
        System.out.println("GPU: "
                + hal.getGpus()[0].getName() + " "
                + FormatUtil.formatBytes(hal.getGpus()[0].getTotalMemory()));
    }

}
