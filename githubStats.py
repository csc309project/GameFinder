# pip install PyGithub
from github import Github
from collections import defaultdict
import datetime
import matplotlib.pylab as plt
import numpy as np

# Authenticate
g = Github("c8b0b555773886f4edb3a7d3e0463a49db8fd9f9")
org = g.get_organization('csc309project')

repo = org.get_repo('GameFinder')
stats = repo.get_stats_commit_activity()

commits_per_week = dict()
for week in stats:
    commits_per_week[week.week] = week.total
counter = 0
commits_per_week = {k.isocalendar()[1] - 12: v for k, v in list(commits_per_week.items()) if k.isocalendar()[1] <= 22 and k.isocalendar()[1] >= 13}
for k,v in commits_per_week.items():
    counter += v
    print("Week:",k, "Number of commits:", v)
print("Total commits:", counter)
commit_numbers = np.array(list(commits_per_week.values()))
std = 3 * np.std(commit_numbers, dtype=np.float64)
mean = np.std(commit_numbers, dtype=np.float64)

plt.plot(*zip(*sorted(commits_per_week.items())), marker='o', markerfacecolor='blue', markersize=8, color='skyblue', linewidth=4)
plt.axhline(y=mean + std, color='r', linestyle='-')
plt.axhline(y=mean - std, color='r', linestyle='-')
plt.title("GitHub Commits Per Week")
plt.xlabel("Week #")
plt.ylabel("# of Commits That Week")
plt.legend(handles2, labels2)
plt.xticks(np.arange(1, 10+1, 1.0))
plt.show()
