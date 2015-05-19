/*******************************************************************************
 * Copyright (c) 2015 Max Rydahl Andersen and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Max Rydahl Andersen- initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.internal.wikitext.asciidoc.core.block;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.mylyn.wikitext.core.parser.Attributes;
import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder.BlockType;
import org.eclipse.mylyn.wikitext.core.parser.markup.Block;

/**
 * quoted text block, matches blocks that start with <code>bq. </code>. Creates a block type of {@link ParagraphBlock
 * paragraph}.
 *
 * @author Max Rydahl Andersen
 */
public class ListBlock extends Block {

	static final Pattern START_PATTERN = Pattern.compile("^([\\*\\.\\-]+) (.*)"); //$NON-NLS-1$

	static final Pattern ITEM_START = START_PATTERN;

	private int blockLineCount;

	@Override
	public int processLineContent(String line, int offset) {
		String listType = null;
		String listContent = null;

		Matcher itemLine = ITEM_START.matcher(line);
		if (itemLine.find()) {
			listType = itemLine.group(1);
			listContent = itemLine.group(2);

			if (blockLineCount == 0) {

				if (listType.startsWith("*") || listType.startsWith("-")) {
					Attributes attributes = new Attributes();
					builder.beginBlock(BlockType.BULLETED_LIST, attributes);
				}

				++blockLineCount;
			}

			if (line.equals("\n")) {
				setClosed(true);
				return -1;
			} else {
				++blockLineCount;
				Attributes attributes = new Attributes();
				builder.beginBlock(BlockType.LIST_ITEM, attributes);
				getMarkupLanguage().emitMarkupLine(getParser(), state, listContent, 0);
				builder.endBlock();
			}
		}
		return -1;
	}

	@Override
	public boolean canStart(String line, int lineOffset) {
		Matcher matcher = START_PATTERN.matcher(line);

		return matcher.matches();
	}

	@Override
	public void setClosed(boolean closed) {
		if (closed && !isClosed()) {
			builder.endBlock(); // close ul/il
		}
		super.setClosed(closed);
	}

}
