Feature: Community-Z communities page

  Background:
    Given the home page is opened
      And the 'cookie accept button' is clicked on home page
      And the 'communities navbar link' is clicked on home page
      And the community page is opened

  Scenario Outline: Search for communities
    When the 'search box' is clicked on communities page
      And the 'search box' is filled with '<searchText>'
    Then first community card text should be '<expectedCardText>'
      And the 'search clear button' should be shown
      And there are one or more communities
      And the 'first community card' is contains the '<searchText>'

    Examples:
      | expectedCardText          | searchText |
      | Z-DAYS – Global Community | Global     |
      | Global Testing Community  | Test       |
      | The Rolling Scopes        | Rolling    |

  Scenario: Search clear button test
    When the 'search box' is clicked on communities page
      And the 'search box' is filled with 'spot'
      And first community card text should be 'DesignSpot Community'
      And the 'search clear button' is clicked on communities page
    Then first community card text should be 'Community-Z'

  Scenario Outline: Filter by location
    When the 'filter location dropdown' is clicked on communities page
      And the 'location search box' is clicked on communities page
      And the 'location search box' is filled with '<filterText>'
      And the 'first dropdown check box' is clicked on communities page
    Then first community card text should be '<expectedCardText>'
      And the 'first filter label' is contains the '<filterText>'
      And the 'first community card' is clicked on communities page
      And the community card page is opened
      And the 'community location' is contains the '<filterText>'

    Examples:
      | expectedCardText           | filterText |
      | Cloud and DevOps - Armenia | Armenia    |
      | SDL Tridion                | Germany    |

  Scenario: Location clear all button test
    When the 'filter location dropdown' is clicked on communities page
      And the 'location search box' is clicked on communities page
      And the 'location search box' is filled with 'hong'
      And the 'first dropdown check box' is clicked on communities page
      And first community card text should be 'HK BA Community'
      And the 'location clear all button' is clicked on communities page
    Then first community card text should be 'Community-Z'
