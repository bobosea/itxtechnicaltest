Feature: E2E test for /price endpoint

  Background:
    * def urlBase = 'http://localhost:8080/price'
    * def requestParamBase = '?productId=35455&brandId=1&applicationDate='

  Scenario: Search price on 14th day at 10:00

    Given url urlBase + requestParamBase + '2020-06-14T10:00:00Z'
    When method GET
    Then status 200
    And response.priceList = 1

  Scenario: Search price on 14th day at 16:00

    Given url urlBase + requestParamBase + '2020-06-14T16:00:00Z'
    When method GET
    Then status 200
    And response.priceList = 2

  Scenario: Search price on 14th day at 21:00

    Given url urlBase + requestParamBase + '2020-06-14T21:00:00Z'
    When method GET
    Then status 200
    And response.priceList = 1

  Scenario: Search price on 15th day at 10:00

    Given url urlBase + requestParamBase + '2020-06-15T10:00:00Z'
    When method GET
    Then status 200
    And response.priceList = 3

  Scenario: Search price on 16th day at 21:00

    Given url urlBase + requestParamBase + '2020-06-16T21:00:00Z'
    When method GET
    Then status 200
    And response.priceList = 4

  Scenario: Not found, year 2021

    Given url urlBase + requestParamBase + '2021-06-14T10:00:00Z'
    When method GET
    Then status 404

  Scenario: Bad request, date bad format

    Given url urlBase + requestParamBase + '2020/06/14T10:00:00Z'
    When method GET
    Then status 400

