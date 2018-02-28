package io.myjd.parser


class MarkdownParser {

    final static def SYNTAX_ELEM_STAR = "*"
    final static def SYNTAX_ELEM_UNDERSCORE = "_"
    final static def SYNTAX_ELEM_ESCAPE = "\\"
    final static def SYNTAX_ELEM_QUOTE = ">"
    final static def SYNTAX_ELEM_HEADER = "#"

    final static def HTML_BOLD = "b"
    final static def HTML_ITALIC = "i"
    final static def HTML_QUOTE = "blockquote"


    String parseTextToHtml(def text) {
        def strBuffer = new StringBuffer()
        def checkNext = true

        strBuffer << "<html>"
        strBuffer << "<body>"
        strBuffer << "<p>"
        text.eachWithIndex { character, index ->
            if (checkNext) {
                switch (character) {
                    case SYNTAX_ELEM_STAR:
                        // Check if the next character is a *
                        if (text[index + 1]?.equals(SYNTAX_ELEM_STAR)) {
                            if(strBuffer.contains("<b>")) {
                                strBuffer << "</b>"
                            } else {
                                strBuffer << "<b>"
                            }
                            checkNext = false
                        } else {
                            if(strBuffer.contains("<i>")) {
                                strBuffer << "</i>"
                            } else {
                                strBuffer << "<i>"
                            }
                        }
                        break
                    case SYNTAX_ELEM_UNDERSCORE:
                        if (text[index + 1]?.equals(SYNTAX_ELEM_UNDERSCORE)) {
                            if(strBuffer.contains("<b>")) {
                                strBuffer << "</b>"
                            } else {
                                strBuffer << "<b>"
                            }
                            checkNext = false
                        } else {
                            if(strBuffer.contains("<i>")) {
                                strBuffer << "</i>"
                            } else {
                                strBuffer << "<i>"
                            }
                        }
                        break
                    default:
                        strBuffer << character

                }
            } else {
                checkNext = true
            }
        }
        strBuffer << "</p>"
        strBuffer << "</body>"
        strBuffer << "</html>"

        println strBuffer.toString()

        strBuffer.toString()

    }
}
