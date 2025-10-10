/*
 * The MIT License
 *
 * Copyright 2019-2022 MobiusCode GmbH.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.moebiusgames.pdfbox.table;

import java.awt.Color;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

/**
 * a prototypic class that contains all information
 * about all cells of that given column. Each cell
 * that is not configured differently will inherit
 * its attributes like borders, fonts and padding
 * from this class. This also incorporates the
 * heading of a column and all the stuff that goes
 * with it.
 */
public class PDFTableColumn {

    private int fontSize = 10;
    private PDFont font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
    private Align align = Align.LEFT;

    private Integer headingFontSize = null;
    private PDFont headingFont = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
    private Align headingAlign = null;
    private Color headingFontColor = null;
    private Color headingBackgroundColor = null;

    private final float width;
    private PDFTableBorder borderLeft = new PDFTableBorder();
    private PDFTableBorder borderRight = new PDFTableBorder();
    private PDFTableBorder borderTop = new PDFTableBorder();
    private PDFTableBorder borderBottom = new PDFTableBorder();

    private float paddingLeft = 4;
    private float paddingRight = 4;
    private float paddingTop = 4;
    private float paddingBottom = 4;
    private Color fontColor = Color.BLACK;
    private Color backgroundColor = null;
    private float lineSpacingFactor = 0.2f;
    private String heading = "[N/A]";
    private Boolean underline = false;
    private final PDFTable table;

    PDFTableColumn(final PDFTable table, float width) {
        this.table = table;
        this.width = width;
    }

    public String getHeading() {
        return heading;
    }

    public PDFTableColumn setHeading(String heading) {
        if (heading == null) {
            throw new IllegalArgumentException("null value not allowed");
        }
        this.heading = heading;
        return this;
    }

    public int getFontSize() {
        return fontSize;
    }

    public PDFTableColumn setFontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public PDFont getFont() {
        return font;
    }

    public PDFTableColumn setFont(PDFont font) {
        this.font = font;
        return this;
    }

    public Align getAlign() {
        return align;
    }

    public PDFTableColumn setAlign(Align align) {
        this.align = align;
        return this;
    }

    /**
     * returns the size of the heading font or if not set the size
     * of the normal cell font
     *
     * @return the font size
     */
    public int getHeadingFontSize() {
        return headingFontSize != null ? headingFontSize : this.getFontSize();
    }

    /**
     * sets the size of the font for the heading or when
     * set to null signals to use the font size used for
     * all other cells
     *
     * @param headingFontSize the font size
     * @return this object for chaining
     */
    public PDFTableColumn setHeadingFontSize(Integer headingFontSize) {
        this.headingFontSize = headingFontSize;
        return this;
    }

    /**
     * returns the font for the cell heading or the cell heading
     * for the normal cells when no special font is set for the
     * heading
     *
     * @return the font
     */
    public PDFont getHeadingFont() {
        return headingFont != null ? headingFont : getFont();
    }

    /**
     * sets the font for the heading or when set to null signals
     * to use the font used for all other cells
     *
     * @param headingFont the font
     * @return this object for chaining
     */
    public PDFTableColumn setHeadingFont(PDFont headingFont) {
        this.headingFont = headingFont;
        return this;
    }

    /**
     * returns the alignment for the cell heading or the cell alignment
     * for the normal cells when no special alignment is set for the
     * heading
     *
     * @return the alignment
     */
    public Align getHeadingAlign() {
        return headingAlign != null ? headingAlign : getAlign();
    }

    /**
     * sets the alignment for the heading or when set to null signals
     * to use the alignment used for all other cells
     *
     * @param headingAlign the alignment
     * @return this object for chaining
     */
    public PDFTableColumn setHeadingAlign(Align headingAlign) {
        this.headingAlign = headingAlign;
        return this;
    }

    /**
     * returns the font color for the cell heading or the font color
     * for the normal cells when no special font color is set for the
     * heading
     *
     * @return the color
     */
    public Color getHeadingFontColor() {
        return headingFontColor != null ? headingFontColor : getFontColor();
    }

    /**
     * sets the font color for the heading or when set to null signals
     * to use the font color used for all other cells
     *
     * @param headingFontColor the font color
     * @return this object for chaining
     */
    public PDFTableColumn setHeadingFontColor(Color headingFontColor) {
        this.headingFontColor = headingFontColor;
        return this;
    }

    /**
     * returns the background color for the cell heading or the background
     * color for the normal cells when no special background color is set for the
     * heading
     *
     * @return the color
     */
    public Color getHeadingBackgroundColor() {
        return headingBackgroundColor != null
                ? headingBackgroundColor
                : getBackgroundColor();
    }

    /**
     * sets the heading background color for the heading or when set
     * to null signals to use the background color used for all other cells
     *
     * @param headingBackgroundColor background color
     * @return this object for chaining
     */
    public PDFTableColumn setHeadingBackgroundColor(Color headingBackgroundColor) {
        this.headingBackgroundColor = headingBackgroundColor;
        return this;
    }

    public float getWidth() {
        return width;
    }

    public PDFTableBorder getBorderLeft() {
        return borderLeft;
    }

    public PDFTableColumn setBorderLeft(PDFTableBorder borderLeft) {
        if (borderLeft == null) {
            throw new IllegalArgumentException("null is not allowed here");
        }
        this.borderLeft = borderLeft;
        return this;
    }

    public PDFTableBorder getBorderRight() {
        return borderRight;
    }

    public PDFTableColumn setBorderRight(PDFTableBorder borderRight) {
        if (borderRight == null) {
            throw new IllegalArgumentException("null is not allowed here");
        }
        this.borderRight = borderRight;
        return this;
    }

    public PDFTableBorder getBorderTop() {
        return borderTop;
    }

    public PDFTableColumn setBorderTop(PDFTableBorder borderTop) {
        if (borderTop == null) {
            throw new IllegalArgumentException("null is not allowed here");
        }
        this.borderTop = borderTop;
        return this;
    }

    public PDFTableBorder getBorderBottom() {
        return borderBottom;
    }

    public PDFTableColumn setBorderBottom(PDFTableBorder borderBottom) {
        if (borderBottom == null) {
            throw new IllegalArgumentException("null is not allowed here");
        }
        this.borderBottom = borderBottom;
        return this;
    }

    /**
     * sets all surrounding borders to the given
     * border
     *
     * @param border the border
     * @return this object for chaining
     */
    public PDFTableColumn setBorder(PDFTableBorder border) {
        this.setBorderLeft(border);
        this.setBorderRight(border);
        this.setBorderTop(border);
        this.setBorderBottom(border);
        return this;
    }

    public PDFTableColumn setPadding(float padding) {
        this.setPaddingLeft(padding);
        this.setPaddingRight(padding);
        this.setPaddingTop(padding);
        this.setPaddingBottom(padding);
        return this;
    }

    public float getPaddingLeft() {
        return paddingLeft;
    }

    public PDFTableColumn setPaddingLeft(float paddingLeft) {
        if (paddingLeft < 0 || paddingLeft + this.paddingRight >= this.width) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.paddingLeft = paddingLeft;
        return this;
    }

    public float getPaddingRight() {
        return paddingRight;
    }

    public PDFTableColumn setPaddingRight(float paddingRight) {
        if (paddingRight < 0 || this.paddingLeft + paddingRight >= this.width) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.paddingRight = paddingRight;
        return this;
    }

    public float getPaddingTop() {
        return paddingTop;
    }

    public PDFTableColumn setPaddingTop(float paddingTop) {
        if (paddingTop < 0) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.paddingTop = paddingTop;
        return this;
    }

    public float getPaddingBottom() {
        return paddingBottom;
    }

    public PDFTableColumn setPaddingBottom(float paddingBottom) {
        if (paddingBottom < 0) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.paddingBottom = paddingBottom;
        return this;
    }

    public float getLineSpacingFactor() {
        return lineSpacingFactor;
    }

    public PDFTableColumn setLineSpacingFactor(float lineSpacingFactor) {
        if (lineSpacingFactor < 0) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.lineSpacingFactor = lineSpacingFactor;
        return this;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public PDFTableColumn setFontColor(Color fontColor) {
        if (fontColor == null) {
            throw new IllegalArgumentException("null value not allowed");
        }
        this.fontColor = fontColor;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public PDFTableColumn setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Boolean getUnderline() {
        return underline;
    }

    public PDFTableColumn setUnderline(Boolean underline) {
        this.underline = underline;
        return this;
    }

}
