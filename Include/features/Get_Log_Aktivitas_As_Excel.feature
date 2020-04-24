#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Test OCR with Clear Image
  	Given Login SLIK
  	And Login SLIK as Supervisor Succeed
  	And Select Tab Menu "Pemantauan"
  	And Select and Expand Left Menu "Pemantauan Aktivitas"
  	And Select Submenu "Log Aktivitas"
  	And Select day-1
  	And Select Today
  	And Click Button "Cari"
  	And Click Button "Download"
  	And Click Toolbar Export