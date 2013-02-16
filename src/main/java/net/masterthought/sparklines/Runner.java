package net.masterthought.sparklines;

import java.io.File;

public class Runner {

    public static void main(String[] args) throws Exception {
        File rd = new File("/Users/kings/.jenkins/jobs/cucumber-jvm/builds/82/jenkins-sparklines");
        SparklinesGenerator sparklinesGenerator = new SparklinesGenerator("FAILURE", "", "/url", rd, "cucumber-jvm");
        sparklinesGenerator.generateBuildStatusBasic();
        sparklinesGenerator.generateBuildStatusJobName();
        sparklinesGenerator.generateOverview();
    }


}
