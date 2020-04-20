package com.github.funthomas424242.jenkinsmonitor.jenkins;

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

import com.github.funthomas424242.jenkinsmonitor.gui.JobStatusZeileOben;
import com.github.funthomas424242.jenkinsmonitor.gui.JobStatusZeileUnten;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class JobStatusBeschreibungen extends AbstractJobBeschreibungen<JobStatusBeschreibung> {

    protected int displayLaengeOben = 0;
    protected int displayLaengeUnten = 0;

    public JobStatusBeschreibungen() {
        super(new HashMap<>());
    }

    public JobStatusBeschreibungen(final Map<String, JobStatusBeschreibung> jobStatusBeschreibungen) {
        super(jobStatusBeschreibungen);
        computeDisplayCharLength();
    }

    protected void computeDisplayCharLength() {

        final Comparator<Integer> maxComparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        };

        this.displayLaengeOben = AbstractJobBeschreibung.sortedStreamOf(this)
            .map(jobStatusBeschreibung -> (jobStatusBeschreibung.getJobName() + jobStatusBeschreibung.getJobOrderId()).length())
            .max(maxComparator)
            .orElseGet(() -> 0);

        this.displayLaengeUnten = AbstractJobBeschreibung.sortedStreamOf(this)
            .map(jobStatusBeschreibung -> jobStatusBeschreibung.getJobUrl().toString().length())
            .max(maxComparator)
            .orElseGet(() -> 0);
    }

    public JobStatusZeileOben getJobStatusZeileOben(final JobStatusBeschreibung jobStatusBeschreibung) {
        return new JobStatusZeileOben(jobStatusBeschreibung.getJobName(), jobStatusBeschreibung.getJobOrderId(), this.displayLaengeOben);
    }

    public JobStatusZeileUnten getJobStatusZeileUnten(final JobStatusBeschreibung jobStatusBeschreibung) {
        return new JobStatusZeileUnten(jobStatusBeschreibung.getJobUrl(), this.displayLaengeUnten, jobStatusBeschreibung.getJobStatus());
    }


}
