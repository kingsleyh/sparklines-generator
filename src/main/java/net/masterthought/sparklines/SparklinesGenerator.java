package net.masterthought.sparklines;


import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Properties;

public class SparklinesGenerator {

    private String buildResult;
    private String pluginUrlPath;
    private String buildUrl;
    private File targetBuildDirectory;
    private String jobName;
    private ArrayList<BuildInformation> jobHistory;


    public SparklinesGenerator(String buildResult, String pluginUrlPath, String buildUrl, File targetBuildDirectory, String jobName, ArrayList<BuildInformation> jobHistory) {
        this.buildResult = buildResult;
        this.pluginUrlPath = pluginUrlPath;
        this.buildUrl = buildUrl;
        this.targetBuildDirectory = targetBuildDirectory;
        this.jobName = jobName;
        this.jobHistory = jobHistory;
    }


    public void generateBuildStatusBasic() throws Exception {
        BuildStatusBasic buildStatusBasic = new BuildStatusBasic(targetBuildDirectory, buildResult, pluginUrlPath, buildUrl);
        buildStatusBasic.generate();
    }

    public void generateBuildStatusJobName() throws Exception {
        BuildStatusJobName buildStatusJobName = new BuildStatusJobName(targetBuildDirectory, buildResult, pluginUrlPath, buildUrl, jobName);
        buildStatusJobName.generate();
    }

    public void generateJobStatusHistory() throws Exception {
        JobStatusHistory jobstatusHistory = new JobStatusHistory(targetBuildDirectory, jobHistory, pluginUrlPath, buildUrl, jobName);
        jobstatusHistory.generate();
    }

    public void generateJobStatusHistoryPie() throws Exception {
        JobStatusHistoryPie jobstatusHistoryPie = new JobStatusHistoryPie(targetBuildDirectory, jobHistory, pluginUrlPath, buildUrl, jobName);
        jobstatusHistoryPie.generate();
    }

    public void generateOverview() throws Exception {
        OverviewPage overviewPage = new OverviewPage(pluginUrlPath, targetBuildDirectory);
        overviewPage.generate();
    }


}
