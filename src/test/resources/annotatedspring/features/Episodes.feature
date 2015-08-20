Feature: Episodes
  Scenario: Creating an episode
    Given there are no episodes
    When I create an episode
    Then I should see it on the episodes page
    And I should be able to view its details