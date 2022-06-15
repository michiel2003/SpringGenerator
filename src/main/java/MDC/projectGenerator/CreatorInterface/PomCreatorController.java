package MDC.projectGenerator.CreatorInterface;

import MDC.projectGenerator.pomGenerator.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class PomCreatorController {

//    parent pom set
    @RequestMapping("/parentPom")
    public String parentPom(@RequestParam(value = "groupId", defaultValue = "") String groupId,
                            @RequestParam(value = "artifactId", defaultValue = "") String artifactId){
//        set group id
        Parent.setGroupId(groupId);
//        set artifact id
        Parent.setArtifactId(artifactId);

//        return the values for debugging
        String debug = "groupId: " + groupId + "\nartifactId: " + artifactId;
        return debug;
    }

//    project data set
    @RequestMapping("/projectData")
    public String projectData(@RequestParam(value = "groupId", defaultValue = "") String groupId,
                            @RequestParam(value = "artifactId", defaultValue = "") String artifactId,
                            @RequestParam(value = "version", defaultValue = "") String version,
                            @RequestParam(value = "name", defaultValue = "") String name,
                            @RequestParam(value = "description", defaultValue = "") String description){
//        set group id
        ProjectData.setGroupId(groupId);
//        set artifact id
        ProjectData.setArtifactId(artifactId);
//        set version
        ProjectData.setVersion(version);
//        set name
        ProjectData.setName(name);
//        set description
        ProjectData.setDescription(description);

//        return the values for debugging
        String debug = "groupId: " + groupId + "\nartifactId: " + artifactId + "\nversion: " + version + "\nname: " + name + "\ndescription: " + description;
        return debug;

    }


//    add a plugin to the plugin list
    @RequestMapping("/addPlugin")
    public String addPlugin(@RequestParam(value = "groupId", defaultValue = "") String groupId,
                            @RequestParam(value = "artifactId", defaultValue = "") String artifactId){
//        create a new plugin
        Plugin plugin = new Plugin(groupId, artifactId);
//        add the plugin to the list
        Build.appendPlugin(plugin);

//        return the values for debugging
        String debug = "groupId: " + groupId + "\nartifactId: " + artifactId;
        return debug;

    }

//    show the whole dependency list
    @RequestMapping("/showDependencies")
    public String showDependencies(){
//        get the list of dependencies
        if(DependencyManager.getDependencies() == null){
            return "List was empty";
        }
        List<Dependency> dependencies = DependencyManager.getDependencies();

//        return the list
        String debug = "";
        for(Dependency dependency : dependencies){
            debug += "groupId: " + dependency.getGroupId() + "\nartifactId: " + dependency.getArtifactId() + "\nscope: " + dependency.getScope() + "\n <br>";
        }
        return debug;
    }

//    remove a plugin from the plugin list
    @RequestMapping("/removePlugin")
    public void removePlugin(@RequestParam(value = "groupId", defaultValue = "") String groupId,
                            @RequestParam(value = "artifactId", defaultValue = "") String artifactId){
//        find the plugin
        Plugin plugin = Build.searchPlugin(groupId, artifactId);
//        remove the plugin from the list
        Build.deletePlugin(plugin);
    }

//    add a dependency to the dependency list
    @RequestMapping("/addDependency")
    public void addDependency(@RequestParam(value = "groupId", defaultValue = "") String groupId,
                            @RequestParam(value = "artifactId", defaultValue = "") String artifactId,
                            @RequestParam(value = "scope", defaultValue = "") String scope){
//        create a new dependency
        Dependency dependency = new Dependency(groupId, artifactId, scope);
//        add the dependency to the list
        DependencyManager.appendDependency(dependency);
    }

//    remove a dependency from the dependency list
    @RequestMapping("/removeDependency")
    public void removeDependency(@RequestParam(value = "groupId", defaultValue = "") String groupId,
                            @RequestParam(value = "artifactId", defaultValue = "") String artifactId){
//        find the dependency
        Dependency dependency = DependencyManager.searchDependency(groupId, artifactId);
//        remove the dependency from the list
        DependencyManager.deleteDependency(dependency);
    }


//    set java properties only javaversion
    @RequestMapping("/javaProperties")
    public void javaProperties(@RequestParam(value = "javaVersion", defaultValue = "") String javaVersion){
//        set java version
        Properties.setJavaVersion(javaVersion);
    }

    @RequestMapping("/createPom")
    public void createPom(){
//        create the pom
        String newPom = pomGen.generateXML();
//        save the pom
        pomGen.savePom(newPom, "textpom.xml");
    }

}
