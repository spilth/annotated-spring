Feature: Episodes
  Scenario: Create a published Episode
    Given there are no episodes
    When I create a published episode
    Then I should see it on the episodes page
    And I should be able to view its details

  Scenario: Create an unpublished Episode
    Given there are no episodes
    When I create an unpublished episode
    Then I should not see it on the episodes page

  Scenario: Edit an Episode
    Given there is an existing episode
    When I edit that episode
    Then I should see my changes reflect on the episode page
    And I should see my changes reflected when I view its details