package io.github.kiber2009.plugin.guide.commands;

import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CalcCommand implements TabExecutor {
    @Override
    public boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command,
                             final @NotNull String label, final @NotNull String @NotNull [] args) {
        if (!sender.hasPermission("guide.calculator")) {
            sender.sendMessage("Недостаточно прав");
            return false;
        }

        if (args.length < 3) {
            sender.sendMessage("Недостаточно аргументов");
            return false;
        } else if (args.length > 3) {
            sender.sendMessage("Слишком много аргументов");
            return false;
        }

        final int n1;
        final int n2;
        try {
            n1 = Integer.parseInt(args[0]);
            n2 = Integer.parseInt(args[2]);
        } catch (final NumberFormatException e) {
            sender.sendMessage("Невалидное число");
            return false;
        }

        switch (args[1]) {
            case "+":
                sender.sendMessage(String.valueOf(n1 + n2));
                break;
            case "-":
                sender.sendMessage(String.valueOf(n1 - n2));
                break;
            case "*":
                sender.sendMessage(String.valueOf(n1 * n2));
                break;
            case "/":
                sender.sendMessage(String.valueOf(n1 / n2));
                break;
            default:
                sender.sendMessage("Невалидная операция");
                return false;
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(final @NotNull CommandSender sender, final @NotNull Command command,
                                                final @NotNull String label, final @NotNull String @NotNull [] args) {
        if (args.length == 2) {
            return List.of("+", "-", "*", "/");
        }
        return List.of();
    }
}
