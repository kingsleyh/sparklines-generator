package net.masterthought.sparklines;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;

public abstract class AbstractPage {

    protected void generateSparkLine(String fileName, File targetBuildDirectory, Template template, VelocityContext context) throws Exception {
         Writer writer = new FileWriter(new File(targetBuildDirectory, fileName));
         template.merge(context, writer);
         writer.flush();
         writer.close();
     }

     protected Properties getProperties() {
         Properties props = new Properties();
         props.setProperty("resource.loader", "class");
         props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
         return props;
     }

}
