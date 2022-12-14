package redditclone.model.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "communities")
public class Community {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "community_id", unique = true, nullable = false)
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private LocalDate creation_date;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "moderator_id", referencedColumnName = "id")
	private User moderator;

	@JsonManagedReference
	@OneToMany(mappedBy = "community")
	private Set<Post> posts;
}
