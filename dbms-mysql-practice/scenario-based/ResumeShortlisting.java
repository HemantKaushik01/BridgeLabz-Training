package secnario_Based;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class InvalidResumeException extends Exception {
	public InvalidResumeException(String message) {
		super(message);
	}
}

class Resume {
	private String name;
	private int matchCount;
	private Set<String> skills;

	public Resume(String name, Set<String> skills) {
		this.name = name;
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(int count) {
		this.matchCount = count;
	}

	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return name + " | Matches: " + matchCount + " | Skills: " + skills;
	}

}

class ResumeService {
	public static void calculateMatch(Resume resume, Set<String> jobSkills) throws InvalidResumeException {
		if (resume.getSkills() == null || resume.getSkills().isEmpty()) {
			throw new InvalidResumeException("Resume has no skills");
		}

		int count = 0;
		for (String skill : resume.getSkills()) {
			if (jobSkills.contains(skill)) {
				count++;
			}
		}
		resume.setMatchCount(count);

	}

}

class ResumeComparator implements Comparator<Resume> {

	@Override
	public int compare(Resume r1, Resume r2) {
		return Integer.compare(r2.getMatchCount(), r1.getMatchCount());
	}
}

public class ResumeShortlisting {

	public static void main(String[] args) {
		Set<String> jobSkills = new HashSet<>();
		jobSkills.add("Java");
		jobSkills.add("Spring");
		jobSkills.add("SQL");

		List<Resume> resumes = new ArrayList<>();

		resumes.add(new Resume("Amit", new HashSet<>(Arrays.asList("Java", "SQL"))));

		resumes.add(new Resume("Neha", new HashSet<>(Arrays.asList("Java", "Spring", "SQL"))));

		resumes.add(new Resume("Rahul", new HashSet<>(Arrays.asList("HTML", "CSS"))));
		for (Resume r : resumes) {
			try {
				ResumeService.calculateMatch(r, jobSkills);
			} catch (InvalidResumeException e) {
				System.out.println("Error for " + r.getName() + ": " + e.getMessage());
			}
		}
		Collections.sort(resumes, new ResumeComparator());

		System.out.println("\n--- Shortlisted Resumes ---");
		for (Resume r : resumes) {
			System.out.println(r);
		}
	}
}
