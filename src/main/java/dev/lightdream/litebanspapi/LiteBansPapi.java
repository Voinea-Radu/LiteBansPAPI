package dev.lightdream.litebanspapi;

import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("FieldCanBeLocal")
public final class LiteBansPapi extends JavaPlugin {

    public final static String PROJECT_NAME = "LiteBansPapi";
    private PAPI papi;

    @Override
    public void onEnable() {
        papi = new PAPI(this);
    }
}
