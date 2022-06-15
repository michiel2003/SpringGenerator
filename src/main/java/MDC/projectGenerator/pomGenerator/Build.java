package MDC.projectGenerator.pomGenerator;

import java.util.List;

public class Build {

    static List<Plugin> plugins;

//    append to plugins
    public static void appendPlugin(Plugin plugin) {
        plugins.add(plugin);
    }

//    delete from plugins
    public static void deletePlugin(Plugin plugin) {
        plugins.remove(plugin);
    }

//    search for plugins
    public static Plugin searchPlugin(String groupId, String artifactId) {
        for (Plugin plugin : plugins) {
            if (plugin.groupId.equals(groupId) && plugin.artifactId.equals(artifactId)) {
                return plugin;
            }
        }
        return null;
    }


}
