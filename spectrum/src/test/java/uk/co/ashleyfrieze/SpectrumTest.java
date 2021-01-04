package uk.co.ashleyfrieze;

//import static org.junit.Assert.*;
import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static com.greghaskins.spectrum.dsl.specification.Specification.let;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.greghaskins.spectrum.Spectrum;

@RunWith(Spectrum.class)
public class SpectrumTest {{

	describe("A square", () -> {
		Supplier<Rectangle> theSquare = let(() -> new Rectangle(5, 5));
		it("is square", () -> {
			assertThat(theSquare.get().isSquare()).isTrue();
		});
	});


}}
