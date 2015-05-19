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

import java.util.regex.Pattern;

import org.eclipse.mylyn.wikitext.core.parser.Attributes;
import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder.BlockType;

/**
 * quoted text block, matches blocks that start with <code>bq. </code>. Creates
 * a block type of {@link ParagraphBlock paragraph}.
 * 
 * @author Max Rydahl Andersen
 */
public class CodeBlock extends AsciiDocBlock {

	public CodeBlock() {
		super(Pattern.compile("^----.*")); //$NON-NLS-1$
	}

	@Override
	protected void processBlockStart() {
		Attributes attributes = new Attributes();
		builder.beginBlock(BlockType.CODE, attributes);
	}

	@Override
	protected void processBlockContent(String line) {
		// getMarkupLanguage().emitMarkupLine(getParser(), state, line, offset);
		builder.characters(line);
		builder.lineBreak();
	}
	
	@Override
	protected void processBlockEnd() {
		builder.endBlock(); // code
	}

}
