package Report;

import java.time.LocalTime;

public class Configure {

    LocalTime frequencyOfGeneratingReports;

    public void ChangeFrequencyOfGeneratingReport(LocalTime frequencyOfGeneratingReports){

    }

    public LocalTime getFrequencyOfGeneratingReports() {
        return frequencyOfGeneratingReports;
    }

    /* this was in design diagram but "ChangeFrequencyOfGeneratingReport" is basically the same thing but maybe this could be used to initalize?
    public void setFrequencyOfGeneratingReports(LocalTime frequencyOfGeneratingReports) {
        this.frequencyOfGeneratingReports = frequencyOfGeneratingReports;
    }
     */
}
