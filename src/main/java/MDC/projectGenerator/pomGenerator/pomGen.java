package MDC.projectGenerator.pomGenerator;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static MDC.projectGenerator.pomGenerator.Parent.relativePath;

@RestController("/pomGen")
public class pomGen {



    public static void savePom(String newPom, String fileString) {
//        get the file
        File file = new File(fileString);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(newPom);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateXML(){
        String XMLtext = Xml.XML_HEADER + "\n" + Xml.XML_ROOT_TAG + "\n";





//        add modelversion
        XMLtext += "<modelVersion>4.0.0</modelVersion>\n";
        XMLtext += parentXML();
        XMLtext += projectData();
        XMLtext += javaVersion();
        XMLtext += dependencies();
        XMLtext += build();
        XMLtext += "</project>\n";


        String indentedXml = Xml.prettyPrintByTransformer(XMLtext, 5, true);




        return indentedXml;
    }

    private static String parentXML(){
        if(Parent.groupId == null || Parent.artifactId  == null){
            return "";
        }
        String parentXML = "<parent>\n";
        parentXML += "<groupId>" + Parent.groupId + "</groupId>\n";
        parentXML += "<artifactId>" + Parent.artifactId + "</artifactId>\n";
        if(Parent.version != null){
            parentXML += "<version>" + Parent.version + "</version>\n";
        } else {
            parentXML += "<version>1.0-SNAPSHOT</version>\n";
        }
        if(Parent.relativePath != null){
            parentXML += "<relativePath>" + relativePath + "</relativePath>\n";
        }else{
            parentXML += "<relativePath/>\n";
        }

        parentXML += "</parent>\n";
        return parentXML;

    }

    private static String projectData(){
        if(ProjectData.groupId == null || ProjectData.artifactId  == null){
            return "";
        }
        String projectData = "<groupId>" + ProjectData.groupId + "</groupId>\n";
        projectData += "<artifactId>" + ProjectData.artifactId + "</artifactId>\n";
        if(ProjectData.version != null){
            projectData += "<version>" + ProjectData.version + "</version>\n";
        } else {
            projectData += "<version>1.0-SNAPSHOT</version>\n";
        }
        if(ProjectData.name != null){
            projectData += "<name>" + ProjectData.name + "</name>\n";
        } else {
            projectData += "<name></name>\n";
        }
        if(ProjectData.description != null){
            projectData += "<description>" + ProjectData.description + "</description>\n";
        } else {
            projectData += "<description></description>\n";
        }
        return projectData;
    }

    public static String javaVersion(){
//       add java version
//        add properties
        String javaVersion = "<properties>\n";
        if (Properties.javaVersion == null){
            javaVersion += "<java.version>1.8</java.version>\n";
        } else {
            javaVersion += "<java.version>" + Properties.javaVersion + "</java.version>\n";
        }
        javaVersion += "</properties>\n";
        return javaVersion;
    }


    public static String dependencies() {
        String dependencies = "<dependencies>\n";
        if(DependencyManager.dependencies == null){
            return "";
        }
        for(Dependency dependency : DependencyManager.dependencies){
            dependencies += "<dependency>\n";
            dependencies += "<groupId>" + dependency.groupId + "</groupId>\n";
            dependencies += "<artifactId>" + dependency.artifactId + "</artifactId>\n";
            if(dependency.scope != null){
                dependencies += "<scope>" + dependency.scope + "</scope>\n";
            } else {
                dependencies += "";
            }
//            close dependency
            dependencies += "</dependency>\n";
        }
        dependencies += "</dependencies>\n";
        return dependencies;
    }

    public static String build(){
        String build = "<build>\n";
//        add plugins
        build += "<plugins>\n";
//        add all plugins in for loop
        for(Plugin plugin : Build.plugins){
            build += "<plugin>\n";
//            check if plugin has groupId
            if(plugin.groupId != null){
                build += "<groupId>" + plugin.groupId + "</groupId>\n";
            }
//            check if plugin has artifactId
            if(plugin.artifactId != null){
                build += "<artifactId>" + plugin.artifactId + "</artifactId>\n";
            }
//            close plugin
            build += "</plugin>\n";
        }
        build += "</plugins>\n";
//        close build
        build += "</build>\n";
        return build;
    }



}
