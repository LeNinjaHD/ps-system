/*
 * This file is part of ps-system, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2020 - 2021 Pasqual Koschmieder and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.derklaro.privateservers.common.translation;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.jetbrains.annotations.NotNull;

import static net.kyori.adventure.text.Component.newline;
import static net.kyori.adventure.text.Component.space;
import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.Component.translatable;

public final class Message {

  private static final Component RESET = Component.text("§r");
  private static final Component PREFIX_COMPONENT = translatable("ps.chat.prefix");

  public static final Args0 COMMAND_NOT_ALLOWED = () -> prefixed(
    translatable("ps.command.not.allowed")
  );

  public static final Args0 WHITELIST_COMMAND_HELP = () -> prefixed(
    translatable("ps.command.help.1"),
    translatable("ps.command.help.2"),
    translatable("ps.command.help.3")
  );

  public static final Args0 WHITELIST_ALREADY = () -> prefixed(
    translatable("ps.command.whitelist.already.whitelisted")
  );

  public static final Args1<String> WHITELIST_COMMAND_ADD = name -> prefixed(
    translatable("ps.command.whitelist.add").args(text(name))
  );

  public static final Args0 WHITELIST_NOT_ON = () -> prefixed(
    translatable("ps.command.whitelist.not.whitelisted")
  );

  public static final Args1<String> WHITELIST_COMMAND_REMOVE = name -> prefixed(
    translatable("ps.command.whitelist.remove").args(text(name))
  );

  public static final Args0 NPC_REMOVE_ALREADY_ACTIVATED = () -> prefixed(
    translatable("ps.command.npc.remove.already")
  );

  public static final Args0 NPC_REMOVE_MODE_ACTIVATED = () -> prefixed(
    translatable("ps.command.npc.remove.activated")
  );

  public static final Args0 NPC_REMOVE_SUCCESSFUL = () -> prefixed(
    translatable("ps.command.npc.remove.successful")
  );

  public static final Args0 NPC_ADD_HELP = () -> prefixed(
    translatable("ps.command.npc.add.help.1")
  );

  public static final Args1<String> NPC_ADD_INVALID_USERNAME = name -> prefixed(
    translatable("ps.command.npc.add.not.minecraft.name").args(text(name))
  );

  public static final Args0 NPC_ADD_SUCCESSFUL = () -> prefixed(
    translatable("ps.command.npc.add.successful")
  );

  public static final Args0 ITEM_USE_NO_PERMISSION = () -> prefixed(
    translatable("ps.inventory.item.use.no.permission")
  );

  public static final Args0 NO_RUNNING_SERVER = () -> prefixed(
    translatable("ps.inventory.main.no-running-server")
  );

  public static final Args0 SERVICE_NOW_STOPPING = () -> prefixed(
    translatable("ps.inventory.main.service-stopping")
  );

  public static final Args0 NOW_CONNECTING = () -> prefixed(
    translatable("ps.inventory.main.connecting-now")
  );

  public static final Args0 SERVICE_CREATED = () -> prefixed(
    translatable("ps.inventory.start.service.created")
  );

  public static final Args0 SERVER_CONNECT_SOON = () -> prefixed(
    translatable("ps.inventory.start.service.connect-shortly")
  );

  private Message() {
    throw new UnsupportedOperationException();
  }

  public static @NotNull Component prefixed(@NotNull Component component) {
    return text()
      .append(PREFIX_COMPONENT)
      .append(space())
      .append(component)
      .append(RESET)
      .build();
  }

  public static @NotNull Component prefixed(@NotNull Component... components) {
    TextComponent.Builder resultingComponent = text();
    for (int i = 0; i < components.length; i++) {
      resultingComponent
        .append(PREFIX_COMPONENT)
        .append(space())
        .append(components[i])
        .append(RESET);
      if (i != components.length - 1) {
        resultingComponent.append(newline());
      }
    }
    return resultingComponent.build();
  }

  public interface Args0 {
    Component build();
  }

  public interface Args1<A0> {
    Component build(A0 arg0);
  }
}
