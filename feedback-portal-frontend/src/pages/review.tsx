import './review.css';
import { useFormik } from "formik";
import * as Yup from "yup";
import axios from "axios";

function ReviewPage() {
  const formik = useFormik({
    initialValues: { fName: "", lName: "", email: "", text: "" },
    validationSchema: Yup.object({
      fName: Yup.string()
        .required("First name is required")
        .matches(/^[a-zA-ZА-Яа-яЁё]+$/, "Only letters allowed"),
      lName: Yup.string()
        .required("Last name is required")
        .matches(/^[a-zA-ZА-Яа-яЁё]+$/, "Only letters allowed"),
      email: Yup.string()
        .email("Invalid email")
        .required("Email is required"),
      text: Yup.string()
        .min(50, "Min 50 characters")
        .required("Text is required")
    }),
    onSubmit: async (values) => {
      try {
        await axios.post("http://localhost:8080/api/v1/feedback-portal/review", values);
        alert("Review submitted successfully");
      } catch (error) {
        alert("Submission failed");
      }
    },
  });

  return (
    <div className="review-container">
      <form onSubmit={formik.handleSubmit} className="review-form">
        <h2 className="review-title">Leave a Review</h2>

        <div className="review-name-group">
          <div className="w-full">
            <label htmlFor="fName" className="review-label">First Name</label>
            <input
              id="fName"
              name="fName"
              type="text"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.fName}
              className="review-input"
            />
            {formik.touched.fName && formik.errors.fName && (
              <div className="review-error">{formik.errors.fName}</div>
            )}
          </div>

          <div className="w-full">
            <label htmlFor="lName" className="review-label">Last Name</label>
            <input
              id="lName"
              name="lName"
              type="text"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.lName}
              className="review-input"
            />
            {formik.touched.lName && formik.errors.lName && (
              <div className="review-error">{formik.errors.lName}</div>
            )}
          </div>
        </div>

        <div>
          <label htmlFor="email" className="review-label">Email</label>
          <input
            id="email"
            name="email"
            type="email"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            value={formik.values.email}
            className="review-input"
          />
          {formik.touched.email && formik.errors.email && (
            <div className="review-error">{formik.errors.email}</div>
          )}
        </div>

        <div>
          <label htmlFor="text" className="review-label">Message</label>
          <textarea
            id="text"
            name="text"
            rows="4"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            value={formik.values.text}
            className="review-textarea"
          />
          {formik.touched.text && formik.errors.text && (
            <div className="review-error">{formik.errors.text}</div>
          )}
        </div>

        <button type="submit" className="review-button">Submit</button>
      </form>
    </div>
  );
}

export default ReviewPage;
