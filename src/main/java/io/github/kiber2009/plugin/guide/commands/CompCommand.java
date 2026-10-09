package io.github.kiber2009.plugin.guide.commands;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.object.ObjectContents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CompCommand implements CommandExecutor {
    @Override
    public boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command,
                             final @NotNull String label, final @NotNull String @NotNull [] args) {
        if (!(sender instanceof final Player player))
            return true;

        final Component text = Component.empty()
                .append(Component.text("компонент")
                        .color(NamedTextColor.DARK_AQUA)
                        .decorate(TextDecoration.UNDERLINED, TextDecoration.BOLD))
                .appendNewline()
                .append(Component.text("213")
                        .color(NamedTextColor.GOLD)
                        .decorate(TextDecoration.OBFUSCATED, TextDecoration.STRIKETHROUGH));

        final Component hover = Component.empty()
                .append(Component.text("Текст при наведении")
                        .hoverEvent(Component.text("Ты навёл сюда курсор")))
                .appendNewline()
                .append(Component.text("Сущность при наведении")
                        .hoverEvent(player))
                .appendNewline()
                .append(Component.text("Предмет при наведении")
                        .hoverEvent(player.getInventory().getItemInMainHand()));

        final Component click = Component.empty()
                .append(Component.text("Открыть ссылку")
                        .clickEvent(ClickEvent.openUrl("https://example.com/")))
                .appendNewline()
                .append(Component.text("Отправить в чат")
                        .clickEvent(ClickEvent.runCommand("/comp")))
                .appendNewline()
                .append(Component.text("Вставить в чат")
                        .clickEvent(ClickEvent.suggestCommand("test")))
                .appendNewline()
                .append(Component.text("Скопировать")
                        .clickEvent(ClickEvent.copyToClipboard("564")))
                .appendNewline()
                .append(Component.text("Вызвать функцию")
                        .clickEvent(ClickEvent.callback((a) ->
                                a.sendMessage(Component.text("000")))));

        final Component translatable =
                Component.translatable("narration.checkbox", "Мы ошиблись", Component.text("Arg"));

        final Component keybind = Component.keybind("key.jump");

        final Component object = Component.empty()
                .append(Component.object(ObjectContents.playerHead("jeb_")))
                .append(Component.object(player))
                .append(Component.object(ObjectContents
                        .sprite(Key.key("minecraft", "items"),
                                Key.key("minecraft", "item/diamond_sword"))));

        sender.sendMessage(text);
        sender.sendMessage(hover);
        sender.sendMessage(click);
        sender.sendMessage(translatable);
        sender.sendMessage(keybind);
        sender.sendMessage(object);
        return true;
    }
}
