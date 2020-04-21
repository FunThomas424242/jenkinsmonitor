package com.github.funthomas424242.jenkinsmonitor.gui;

/*-
 * #%L
 * Jenkins Monitor
 * %%
 * Copyright (C) 2019 - 2020 PIUG
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

import com.github.funthomas424242.jenkinsmonitor.jenkins.JobStatus;

import java.net.URL;

public class JobStatusZeileUnten {

    protected final int listIndex;

    //
    protected final JobStatus jobStatus;

    // eindeutig aber wenn mehrmals konfiguriert, werden alle auf einen abgebildet.
    protected final URL jobUrl;

    // maximale Länge der Anzeige aller Zeilen
    protected final int maxLen;


    public JobStatusZeileUnten(final int listIndex, final URL jobUrl, final int maxLen, final JobStatus jobStatus) {
        this.listIndex = listIndex;
        this.jobUrl = jobUrl;
        this.maxLen = maxLen;
        this.jobStatus = jobStatus;
    }

    public String toHTMLString() {

        // Platz für Status Darstellung berechnen
        final String status = this.jobStatus.toString() != null ? this.jobStatus.toString() : "unbekannt";
        String pufferStatus = "";
        // UNSTABLE ist aktuell der längste Status Name
        for (int i = 0; i < (JobStatus.UNSTABLE.name().length() - status.length()); i++) {
            pufferStatus += "&nbsp;";
        }

        // Platz für URL Link berechnen
        final String newUrl = jobUrl != null ? jobUrl.toString() : "<no url>";
        final String untereZeile = newUrl;

        final int deltaUnten = maxLen - untereZeile.length();
        String pufferUrl = "";
        for (int i = 0; i < deltaUnten; i++) {
            pufferUrl += "&nbsp;";
        }

        // Zeile zusammenbauen
        return "<div style=\"font-size:14\">(" + this.listIndex + ") Status: " + status + pufferStatus + " <a href=\"#\">" + newUrl + "</a>" + pufferUrl + "</div>";
    }

}
