package com.github.funthomas424242.jenkinsmonitor;

/*-
 * #%L
 * Jenkins Monitor
 * %%
 * Copyright (C) 2019 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JenkinsMonitorTrayTest {

    JenkinsMonitorTray jenkinsMonitorTray;

    @BeforeEach
    public void setUp() {
        jenkinsMonitorTray = new JenkinsMonitorTray();
        jenkinsMonitorTray.show();
    }

    @Test
    @Disabled
    @DisplayName("Erzeuge ein graues Image mit Breite 5 und Höhe 10")
    public void createGrauesImage() {
        final BufferedImage grayImage = jenkinsMonitorTray.createGrayImage();
        assertEquals(5,grayImage.getWidth());
        assertEquals(10,grayImage.getHeight());
//        assertEquals("No jobs watching", grayImage.getToolTip());
    }




    @Test
    @DisplayName("Initial zeigt der Tooltipp <<No jobs watching>>")
    public void shouldShowNoJobsWatching() throws AWTException {
        final TrayIcon trayIcon = jenkinsMonitorTray.getTrayIcon();
        assertEquals("No jobs watching", trayIcon.getToolTip());
    }


    @Test
    @Disabled
    @DisplayName("Erzeuge ein graues TrayIcon mit Tooltipp: No jobs watching")
    public void createNoJobsWatching() {
        final TrayIcon trayIcon = jenkinsMonitorTray.getTrayIcon();
        assertEquals("No jobs watching", trayIcon.getToolTip());
    }


    @Test
    @Disabled
    @DisplayName("Erzeuge ein grünes TrayIcon")
    public void createOneJobGreen() {
        final TrayIcon trayIcon = jenkinsMonitorTray.getTrayIcon();
        assertEquals("No jobs watching", trayIcon.getToolTip());
    }


    @Test
    @Disabled
    @DisplayName("Der Tooltipp soll einen Eintrag enthalten: <<MultibranchJob/master success>>")
    public void shouldShowOneJobWatching() {
        final Configuration configuration = new OneJobConfiguration();
        jenkinsMonitorTray.reloadConfiguration(configuration);
        final TrayIcon trayIcon = jenkinsMonitorTray.getTrayIcon();
//        assertEquals("MulitbranchJob/master s/uccess", trayIcon.getToolTip());
    }

    @Test
    @Disabled
    public void show() {
        jenkinsMonitorTray.getTrayIcon();
    }

}
