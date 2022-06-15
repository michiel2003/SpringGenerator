package MDC.projectGenerator.pomGenerator;

import java.util.ArrayList;
import java.util.List;

public class DependencyManager {

    static List<Dependency> dependencies = new ArrayList<>();


//append a dependency to the dependency list
    public static void appendDependency(Dependency dependency) {
        dependencies.add(dependency);
    }

    public static void deleteDependency(Dependency dependency) {
        dependencies.remove(dependency);
    }

    public static Dependency searchDependency(String groupId, String artifactId) {
        for (Dependency dependency : dependencies) {
            if (dependency.getGroupId().equals(groupId) && dependency.getArtifactId().equals(artifactId)) {
                return dependency;
            }
        }
        return null;
    }

    public static List<Dependency> getDependencies() {
        return dependencies;
    }

    public static void setDependencies(List<Dependency> dependencies) {
        DependencyManager.dependencies = dependencies;
    }
}
