package net.masterthought.sparklines;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;

public class OverviewPage {

    private final String pluginUrlPath;
    private final File targetBuildDirectory;

    public OverviewPage(String pluginUrlPath, File targetBuildDirectory) {
        this.pluginUrlPath = pluginUrlPath;
        this.targetBuildDirectory = targetBuildDirectory;
    }

    public void generate() throws Exception {
        VelocityEngine ve = new VelocityEngine();
        ve.init(getProperties());
        Template template = ve.getTemplate("templates/overview.vm");
        VelocityContext context = new VelocityContext();
        context.put("css_url", pluginUrlPath + "plugin/jenkins-sparklines/default.css");
        generateSparkLine("overview.html", targetBuildDirectory, template, context);
    }

    private void generateSparkLine(String fileName, File targetBuildDirectory, Template template, VelocityContext context) throws Exception {
        Writer writer = new FileWriter(new File(targetBuildDirectory, fileName));
        template.merge(context, writer);
        writer.flush();
        writer.close();
    }

    private Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("resource.loader", "class");
        props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return props;
    }

}











