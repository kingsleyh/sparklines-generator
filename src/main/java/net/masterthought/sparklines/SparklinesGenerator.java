package net.masterthought.sparklines;


import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;

public class SparklinesGenerator {

    private String buildResult;
    private String pluginUrlPath;
    private String buildUrl;
    private File targetBuildDirectory;
    private String jobName;


    public SparklinesGenerator(String buildResult, String pluginUrlPath, String buildUrl, File targetBuildDirectory, String jobName) {
        this.buildResult = buildResult;
        this.pluginUrlPath = pluginUrlPath;
        this.buildUrl = buildUrl;
        this.targetBuildDirectory = targetBuildDirectory;
        this.jobName = jobName;
    }


    public void generateBuildStatusBasic() throws Exception {
        BuildStatusBasic buildStatusBasic = new BuildStatusBasic(targetBuildDirectory, buildResult, pluginUrlPath, buildUrl);
        buildStatusBasic.generate();
    }

    public void generateBuildStatusJobName() throws Exception {
        BuildStatusJobName buildStatusJobName = new BuildStatusJobName(targetBuildDirectory, buildResult, pluginUrlPath, buildUrl, jobName);
        buildStatusJobName.generate();
    }

    public void generateOverview() throws Exception {
        OverviewPage overviewPage = new OverviewPage(pluginUrlPath, targetBuildDirectory);
        overviewPage.generate();
    }


}
