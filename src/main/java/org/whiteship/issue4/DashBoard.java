package org.whiteship.issue4;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DashBoard {

    private static final String QAUTH = "~~";

    private final Map<String, Integer> userParticipationMap;
    private GHRepository repository;

    public DashBoard(String repositoryName) throws IOException {
        userParticipationMap = new HashMap<>();
        SetUp(repositoryName);
    }

    public void makeBoard() throws IOException {
        List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);

        for(GHIssue issue: issues) {
            countParticipation(issue.getComments());
        }

        // show dashboard
        showPercentage(issues.size());
    }

    private void showPercentage(int totalIssue) {
        System.out.printf("--- 과제 참여 현황 (총 이슈개수 %d) ---\n", totalIssue);
        Set<Map.Entry<String, Integer>> entries = userParticipationMap.entrySet();

        for(Map.Entry<String, Integer> entry : entries) {
            double rate = (entry.getValue()*100.0)/totalIssue;
            System.out.printf("USER: %-20s  참여율: %.2f\n", entry.getKey(), rate);
        }

    }

    private void countParticipation(List<GHIssueComment> comments) throws IOException {
        for (GHIssueComment comment: comments) {
            String name = comment.getUser().getName();

            if(this.userParticipationMap.containsKey(name)) {
               int count =  userParticipationMap.get(name);
                userParticipationMap.put(name, count+1);
            }else {
                userParticipationMap.put(name, 1);
            }
        }
    }

    public void SetUp(String repositoryName) throws IOException {
        GitHub github = new GitHubBuilder().withOAuthToken(QAUTH).build();
        repository = github.getRepository(repositoryName).getSource();
    }
}
