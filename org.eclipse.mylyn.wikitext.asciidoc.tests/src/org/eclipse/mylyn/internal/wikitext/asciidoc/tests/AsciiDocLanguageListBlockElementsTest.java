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
public class AsciiDocLanguageListBlockElementsTest extends AsciiDocLanguageTestBase {

	@Test
	public void basicUnorderedList() {
		String html = parseToHtml(
				"* Edgar Allen Poe\n"
				+ "* Sheri S. Tepper\n"
				+ "* Bill Bryson\n"
				+ "\n");
		assertEquals("<ul>"
				+ "<li>Edgar Allen Poe</li>"
				+ "<li>Sheri S. Tepper</li>"
				+ "<li>Bill Bryson</li>"
				+ "</ul>", html);
	}
	
	@Test
	public void basicUnorderedListWithDash() {
		String html = parseToHtml(
				"- Edgar Allen Poe\n"
				+ "- Sheri S. Tepper\n"
				+ "- Bill Bryson\n"
				+ "\n");
		assertEquals("<ul>"
				+ "<li>Edgar Allen Poe</li>"
				+ "<li>Sheri S. Tepper</li>"
				+ "<li>Bill Bryson</li>"
				+ "</ul>", html);
	}
	
	
	@Test
	public void basicNestedUnorderedList() {
		String html = parseToHtml("* West wood maze" 
				+ "** Maze heart"
				+ "*** Reflection pool"
				+ "** Secret exit"
				+ "* Untracked file in git repository");
		assertEquals("<ul>" + 
				"<li>" + 
				"<p>Maze heart</p>" + 
				"<div class=\"ulist\">" + 
				"<ul>" + 
				"<li>" + 
				"<p>Reflection pool</p>" + 
				"</li>" + 
				"</ul>" + 
				"</div>" + 
				"</li>" + 
				"<li>" + 
				"<p>Secret exit</p>" + 
				"</li>" + 
				"</ul>", html
				);
		
	
	}
	
}
