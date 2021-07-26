package dev.lightdream.litebanspapi;

import litebans.api.Database;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"unused"})
public class PAPI extends PlaceholderExpansion {

    private final LiteBansPapi plugin;

    public PAPI(LiteBansPapi plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public @NotNull String getAuthor() {
        return "L1ghtDream";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "litebanspapi";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String identifier) {

        switch (identifier){
            case "bans":
                return String.valueOf(plugin.bans);
            case "warns":
                return String.valueOf(plugin.warns);
            case "kicks":
                return String.valueOf(plugin.kicks);
            case "mutes":
                return String.valueOf(plugin.mutes);
        }

        return null;
    }

}
