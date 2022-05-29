package com.iridium.iridiumteams.database;

import com.j256.ormlite.field.DatabaseField;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
@Setter
public class IridiumUser<T extends Team> {

    @DatabaseField(columnName = "uuid", canBeNull = false, id = true)
    private @NotNull UUID uuid;

    @DatabaseField(columnName = "name", canBeNull = false)
    private @NotNull String name;

    @Setter(AccessLevel.PRIVATE)
    @DatabaseField(columnName = "team_id", canBeNull = false)
    private int teamID;

    @DatabaseField(columnName = "join_time")
    private long joinTime;

    public void setTeam(T t) {
        teamID = t.getId();
    }

    public Player getPlayer() {
        return Bukkit.getServer().getPlayer(uuid);
    }
}
