/*******************************************************************************
 * Copyright (c) 2007, 2008 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.internal.wikitext.asciidoc.core.block;

import java.util.regex.Pattern;

public class CommentBlock extends AsciiDocBlock {

	public CommentBlock() {
		super(Pattern.compile("^/////*")); //$NON-NLS-1$
	}

	@Override
	protected void processBlockStart() {
		// do nothing for comments
	}

	@Override
	protected void processBlockContent(String line) {
		// do nothing for comments
	}

	@Override
	protected void processBlockEnd() {
		// do nothing for comments
	}

}
