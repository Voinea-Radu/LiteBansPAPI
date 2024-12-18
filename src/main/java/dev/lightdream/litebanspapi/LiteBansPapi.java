package dev.lightdream.litebanspapi;

import litebans.api.Database;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("FieldCanBeLocal")
public final class LiteBansPapi extends JavaPlugin {

    public static LiteBansPapi plugin;
    public int bans;
    public int warns;
    public int kicks;
    public int mutes;

    @Override
    public void onEnable() {
        plugin = this;
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PAPI(LiteBansPapi.plugin).register();
        } else {
            System.out.println("Could not find PlaceholderAPI! This plugin is required.");
        }

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
            String query = "SELECT COUNT(*) FROM {bans}";
            try (PreparedStatement st = Database.get().prepareStatement(query)) {
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        bans = (int) rs.getLong(1);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            query = "SELECT COUNT(*) FROM {warnings}";
            try (PreparedStatement st = Database.get().prepareStatement(query)) {
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        warns = (int) rs.getLong(1);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            query = "SELECT COUNT(*) FROM {kicks}";
            try (PreparedStatement st = Database.get().prepareStatement(query)) {
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        kicks = (int) rs.getLong(1);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            query = "SELECT COUNT(*) FROM {mutes}";
            try (PreparedStatement st = Database.get().prepareStatement(query)) {
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        mutes = (int) rs.getLong(1);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }, 0, 20 * 10);
    }
}
