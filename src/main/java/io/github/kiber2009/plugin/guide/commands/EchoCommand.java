package io.github.kiber2009.plugin.guide.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.Collections;

public class EchoCommand implements BasicCommand {
    @Override
    public void execute(final CommandSourceStack commandSourceStack, final String @NonNull [] args) {
        commandSourceStack.getSender().sendMessage(Component.text(String.join(" ", args)));
    }

    @Override
    public @NonNull Collection<String> suggest(final CommandSourceStack commandSourceStack,
                                               final String @NonNull [] args) {
        return Collections.singleton(commandSourceStack.getSender().getName());
    }

    @Override
    public boolean canUse(final @NonNull CommandSender sender) {
        if (!(sender instanceof final Player player))
            return true;

        return player.getInventory().getItemInMainHand().getAmount() > 0;
    }
}
