package io.github.kiber2009.plugin.guide.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class AllowCommand implements CommandExecutor {
    private final Plugin plugin;

    public AllowCommand(final Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command,
                             final @NotNull String label, final @NotNull String @NotNull [] args) {
        if (args.length != 1) {
            return false;
        }

        final PermissionAttachment attachment = Objects.requireNonNull(sender.addAttachment(plugin, 20 * 10));
        attachment.setPermission(args[0], true);

        return true;
    }
}
