package io.github.kiber2009.plugin.guide;

import io.github.kiber2009.plugin.guide.commands.AllowCommand;
import io.github.kiber2009.plugin.guide.commands.CalcCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GuidePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        registerCommand("calculator", new CalcCommand());
        Objects.requireNonNull(getCommand("allow")).setExecutor(new AllowCommand(this));
    }

    private <T extends CommandExecutor & TabCompleter> void registerCommand(final String name, final T command) {
        final PluginCommand cmd = Objects.requireNonNull(getCommand(name));
        cmd.setExecutor(command);
        cmd.setTabCompleter(command);
    }
}
