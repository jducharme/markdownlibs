package io.myjd.parser

import spock.lang.Specification

class MarkdownParserSpec extends Specification{

    void "Test Basic Italic"() {
        when: "You have one italic word in a String"
            def stringToTest = "I am an *italic* word"

        then: ""
            print new MarkdownParser().parseTextToHtml(stringToTest)
    }

    void "Test basic underscore Italic"() {
        when: "You have one italic word in a String"
        def stringToTest = "I am an _italic_ word"

        then: ""
        print new MarkdownParser().parseTextToHtml(stringToTest)
    }

    void "Test Basic Bold"() {
        when: "You have one bold word in a String"
        def stringToTest = "I am an **bold** word"

        then: ""
        print new MarkdownParser().parseTextToHtml(stringToTest)
    }

    void "Test Basic underscore Bold"() {
        when: "You have one bold word in a String"
        def stringToTest = "I am an __bold__ word"

        then: ""
        print new MarkdownParser().parseTextToHtml(stringToTest)
    }
}
