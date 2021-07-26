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
        return LiteBansPapi.PROJECT_NAME.toLowerCase();
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String identifier) {
        if (player == null) {
            return null;
        }

        List<String> allowedMethods = Arrays.asList("bans", "mutes", "warnings", "kicks");
        if(allowedMethods.contains(identifier)){
            String query = "SELECT COUNT(*) FROM {"+ identifier + "}";
            try (PreparedStatement st = Database.get().prepareStatement(query)) {
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        return String.valueOf(rs.getLong(1));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
