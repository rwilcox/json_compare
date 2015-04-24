#!/bin/env groovy

import groovy.json.JsonSlurper

def fileOneJson = new JsonSlurper().parse( new File("test/a.json") )
def fileTwoJson = new JsonSlurper().parse( new File("test/b.json") )

def fileOneJsonKeys = fileOneJson.keySet()

fileOneJsonKeys.each { currentKey -> 

	def fileOneValue = fileOneJson[currentKey]
	def fileTwoValue = fileTwoJson[currentKey]

	println(fileOneValue)
	/*if (fileTwoValue == null) {
		println "** ERROR: ${currentKey} not found in document 2. Value was: ${fileOneJson[currentKey]}"
	} */

	if (fileTwoValue != fileOneValue) {
		println "** ERROR: ${currentKey} is different in two documents. Value 1: ${fileOneValue} / ${fileTwoValue}"
	}
	
	if (fileOneJson[currentKey].getClass() != String) {
		println "    is object"
	}
}
