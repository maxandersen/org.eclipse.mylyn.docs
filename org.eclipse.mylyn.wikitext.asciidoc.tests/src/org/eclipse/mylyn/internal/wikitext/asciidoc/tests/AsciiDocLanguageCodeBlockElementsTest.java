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

package org.eclipse.mylyn.internal.wikitext.asciidoc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for asciidoc block elements.
 *
 * @author Max Rydahl Andersen
 */
public class AsciiDocLanguageCodeBlockElementsTest extends AsciiDocLanguageTestBase {

	@Test
	public void basicCodeBlock() {
		String html = parseToHtml("----\n"
				+ "10 PRINT \"Hello World!\"\n"
				+ "20 GOTO 10\n"
				+ "----");
		assertEquals("<pre><code>"
				+ "10 PRINT \"Hello World!\"<br/>"
				+ "20 GOTO 10<br/>"
				+ "</code></pre>", html);
	}
	
	@Test 
	public void unbalancedCodeBlock() {
		// ascidoctor requires matching start/end blocks
		// http://asciidoctor.org/docs/user-manual/#delimiter-lines
		String html = parseToHtml("----\n"
				+ "10 PRINT \"Hello World!\"\n"
				+ "20 GOTO 10\n"
				+ "---");
		assertEquals("<pre><code>"
				+ "10 PRINT \"Hello World!\"<br/>"
				+ "20 GOTO 10<br/>"
				+ "---<br/>"
				+ "</code></pre>", html);
		
	}
	
}
